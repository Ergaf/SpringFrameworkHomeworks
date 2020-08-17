
//классы динамических елементов -----------------------------------------------------------------
class Customer {
    constructor(id, elem, name, email, age, accounts) {
        this._id = id;
        this._name = name;
        this._email = email;
        this._age = age;
        this._accounts = accounts;
        this._elem = elem;
        this._elem.onclick = this.onClick.bind(this)
        this.render()
    }
    render(){
        this._elem.innerHTML = `<div class="cus-name-delete">X</div>
                                <p class="cus-elem-info">name: ${this._name}</p>
                                <p class="cus-elem-info">email: ${this._email}</p>
                                <p class="cus-elem-info">age: ${this._age}</p>
                                <p class="cus-elem-info">accounts:</p>
                                <div class="accounts">
                                    
                                </div>
                                <p class="cus-elem-info">employers:</p>
                                <div class="employers">
                                    <div class="employers">employer</div>
                                    <div class="employers">employer</div>
                                </div>`
        this._accounts.forEach(e => {
            let account = document.createElement("div")
            account.classList.add("accountUnit")
            account.innerText = e.currency
            this._elem.querySelector(".accounts").appendChild(account)
        })
    }

    async onClick(){
        console.log(event.target);
        if(event.target === this._elem.querySelector(".cus-name-delete")){
            await this.delete()
        } else
        if(event.target !== this._elem.querySelector(".cus-name-delete")){
            await this.showThisCustomerWindow()
        }
    }
    async delete(){
        let res = await createFetch(`http://localhost:9000/customer/${this._id}`, "DELETE")
        console.log(res);
        if(res){
            await this._elem.remove()
        }
    }
    showThisCustomerWindow(){
        console.log("показал модалку");
        document.querySelector(".Customers-plate").classList.add("nodisplay")
        document.querySelector(".thisCustomer").classList.remove("nodisplay")
        document.querySelector("#thisCustomerPName").innerText = "name: "+this._name
        document.querySelector("#thisCustomerPEmail").innerText = "email: "+this._email
        document.querySelector("#thisCustomerPAge").innerText = "age: "+this._age
        document.querySelector(".idToChange").innerText = this._id
        document.querySelector(".this-customer-accounts").innerHTML = "<div class=\"accountUnitThisC\">add new account</div>"
        document.querySelector(".accountUnitThisC").addEventListener("click", function () {
            document.querySelector(".modal-fon").classList.remove("nodisplay")
            document.querySelector(".modal-add-new-acc").classList.remove("nodisplay")
        })
        this._accounts.forEach(e => {
            let account = document.createElement("div")
            new AccountUnit(account, e.id, e.currency, e.number, e.balance)
        })
    }
}
// -----------------------------------------------------------------------------------------------
class AccountUnit {
    constructor(elem, id, currency, number, balance) {
        this._elem = elem;
        this._id = id;
        this._currency = currency;
        this._number = number;
        this._balance = balance;
        this._elem.onclick = this.onClick.bind(this)
        this.render()
    }

    onClick(){
        console.log("syka");
    }
    render(){
        this._elem.classList.add("accountUnitThisC")
        this._elem.innerText = `Acc: ${this._number}, ${this._currency}, balance: ${this._balance}`
        document.querySelector(".this-customer-accounts").appendChild(this._elem)
    }
}
//------------------------------------------------------------------------------------------------

//модалка addNewCustomers ------------------------------------------------------------------------
document.querySelector(".addnew").addEventListener("click", function () {
    document.querySelector(".modal-fon").classList.remove("nodisplay")
    document.querySelector(".modal-add-new").classList.remove("nodisplay")
})
document.querySelector("#cancelNewCModal").addEventListener("click", function () {
    document.querySelector(".modal-fon").classList.add("nodisplay")
    document.querySelector(".modal-add-new").classList.add("nodisplay")
})

document.querySelector("#saveNewB").addEventListener("click", async function () {
    let name = document.querySelector("#newCName").value
    let email = document.querySelector("#newCMail").value
    let age = parseInt(document.querySelector("#newCAge").value, 10)
    let data = {
        "name": name,
        "email": email,
        "age": age
    }
    console.log(JSON.stringify(data));
    const res = await createFetch("http://localhost:9000/customer", "POST", data)
    if(res){
        let container = document.querySelector(".cus-grid")
        let before = document.querySelector(".addnew")
        renderOneCustomer(res, before, container)
        document.querySelector(".modal-fon").classList.add("nodisplay")
        document.querySelector(".modal-add-new").classList.add("nodisplay")
    }
    console.log(res);
})
//-------------------------------------------------------------------------------------------------

// модалка Add new Account ------------------------------------------------------------------------
document.querySelector("#cancelNewAccountModal").addEventListener("click", function () {
    document.querySelector(".modal-fon").classList.add("nodisplay")
    document.querySelector(".modal-add-new-acc").classList.add("nodisplay")
})
document.querySelector("#saveNewA").addEventListener("click", async function () {
    let id = document.querySelector(".idToChange").innerText
    let currency = document.querySelector("#currencySelect").value
    if(currency !== ""){
        document.querySelector("#currencySelect").classList.remove("wrong")
        let data = {
            "currency": currency,
        }
        const res = await createFetch(`http://localhost:9000//customer/${id}/account`, "PUT", data)
        console.log(res);
        if(res){
            let account = document.createElement("div")
            new AccountUnit(account, res.id, res.currency, res.number, res.balance)
            document.querySelector(".modal-fon").classList.add("nodisplay")
            document.querySelector(".modal-add-new-acc").classList.add("nodisplay")
        }
    } else {
        document.querySelector("#currencySelect").classList.add("wrong")
    }
})
//-------------------------------------------------------------------------------------------------

//Change Customer ---------------------------------------------------------------------------------
document.querySelector(".back-button").addEventListener("click", function () {
    document.querySelector(".Customers-plate").classList.remove("nodisplay")
    document.querySelector(".thisCustomer").classList.add("nodisplay")
})
//-------------------------------------------------------------------------------------------------

//перерисовка Customers ---------------------------------------------------------------------------
async function reRenderCustomers() {
    let container = document.querySelector(".cus-grid")
    container.querySelectorAll(".cus-element").forEach(e => e.remove())
    let before = document.querySelector(".addnew")
    const response = await createFetch("http://localhost:9000/customer", "GET")
    console.log(response);
    response.forEach(e => {
        renderOneCustomer(e, before, container)
    })
}
function renderOneCustomer(customer, before, container){
    let elem = document.createElement("div")
    new Customer(customer.id, elem, customer.name, customer.email, customer.age, customer.accounts)
    elem.classList.add("cus-element")
    container.insertBefore(elem, before)
}
//--------------------------------------------------------------------------------------------------

// нопки хедера ------------------------------------------------------------------------------------
document.querySelectorAll(".header-button").forEach(e => {
    e.addEventListener("click", function(){
        document.querySelectorAll(".header-button").forEach(y => {
            y.classList.remove("set-header-button")
        })
        document.querySelectorAll(".choice").forEach(y => {
            y.classList.add("nodisplay")
        })
        if(event.target === document.querySelector("#home")){
            document.querySelector("#home").classList.add("set-header-button")
            document.querySelector(".home").classList.remove("nodisplay")
        }
        if(event.target === document.querySelector("#customers-b")){
            document.querySelector("#customers-b").classList.add("set-header-button")
            document.querySelector(".Customers-plate").classList.remove("nodisplay")
            reRenderCustomers();
        }
        if(event.target === document.querySelector("#account-b")){
            document.querySelector("#account-b").classList.add("set-header-button")
            document.querySelector(".Accounts-plate").classList.remove("nodisplay")
        }
        if(event.target === document.querySelector("#employers-b")){
            document.querySelector("#employers-b").classList.add("set-header-button")
            document.querySelector(".Employers-plate").classList.remove("nodisplay")
        }
    })
})
//--------------------------------------------------------------------------------------------------

//функция отправки запросов ------------------------------------------------------------------------
async function createFetch(adres, method, data){
    let loader = document.querySelector(".loader")
    loader.classList.remove("nodisplay")
    loader.innerText = "loading..."
    const response = await fetch(adres, {
        method: method,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    }).catch(e => {
        console.log('Bad URL: ', e)
        loader.innerText = e
    });
    let res = await response.json();
    document.querySelector(".loader").classList.add("nodisplay")
    return res;
}
//--------------------------------------------------------------------------------------------------