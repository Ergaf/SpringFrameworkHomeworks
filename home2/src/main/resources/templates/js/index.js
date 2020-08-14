
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
        this._elem.innerHTML = `<div class="cus-name-delete">X</div>
                                <p class="cus-elem-info">name: ${name}</p>
                                <p class="cus-elem-info">email: ${email}</p>
                                <p class="cus-elem-info">age: ${age}</p>
                                <div class="accounts">accounts: ${accounts}</div>`
    }
    async onClick(){
        console.log(event.target);
        if(event.target === this._elem.querySelector(".cus-name-delete")){
            await this.delete()
        } else
        if(event.target !== this._elem.querySelector(".cus-name-delete")){
            await this.showModal()
        }
    }
    async delete(){
        let res = await createFetch(`http://localhost:9000/customer/${this._id}`, "DELETE")
        console.log(res);
        if(res){
            await this._elem.remove()
        }
    }
    showModal(){
        console.log("показал модалку");
    }
}
//------------------------------------------------------------------------------------------------

//модалка addNewCustomers ------------------------------------------------------------------------
document.querySelector(".addnew").addEventListener("click", function () {
    document.querySelector(".modal-fon").classList.remove("nodisplay")
    document.querySelector(".modal-add-new").classList.remove("nodisplay")
})
document.querySelector(".cancel-add-new-customer").addEventListener("click", function () {
    document.querySelector(".modal-fon").classList.add("nodisplay")
    document.querySelector(".modal-add-new").classList.add("nodisplay")
})

document.querySelector(".save-new-modal-button").addEventListener("click", async function () {
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
        let elem = document.createElement("div")
        new Customer(res.id, elem, res.name, res.email, res.age, res.accounts)
        elem.classList.add("cus-element")
        container.insertBefore(elem, before)
        document.querySelector(".modal-fon").classList.add("nodisplay")
        document.querySelector(".modal-add-new").classList.add("nodisplay")
    }
    console.log(res);
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
        let elem = document.createElement("div")
        new Customer(e.id, elem, e.name, e.email, e.age, e.accounts)
        elem.classList.add("cus-element")
        elem.setAttribute("id", e.id)
        container.insertBefore(elem, before)
    })
}
//--------------------------------------------------------------------------------------------------

// нопки хедера ------------------------------------------------------------------------------------
document.querySelectorAll(".header-button").forEach(e => {
    e.addEventListener("click", function(){
        document.querySelectorAll(".choice").forEach(e => {
            e.classList.add("nodisplay")
        })
        if(event.target === document.querySelector("#home")){
            document.querySelector(".home").classList.remove("nodisplay")
        }
        if(event.target === document.querySelector("#customers-b")){
            document.querySelector(".Customers-plate").classList.remove("nodisplay")
            reRenderCustomers();
        }
        if(event.target === document.querySelector("#account-b")){
            document.querySelector(".Accounts-plate").classList.remove("nodisplay")
        }
        if(event.target === document.querySelector("#employers-b")){
            document.querySelector(".Employers-plate").classList.remove("nodisplay")
        }
    })
})
//--------------------------------------------------------------------------------------------------

//функция отправки запросов ------------------------------------------------------------------------
async function createFetch(adres, method, data){
    const response = await fetch(adres, {
        method: method,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    }).catch(e => {console.log('Bad URL: ', e)});
    let res = await response.json();
    return res;
}
//--------------------------------------------------------------------------------------------------