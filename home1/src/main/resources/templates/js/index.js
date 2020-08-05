
// нопки хедера
document.querySelector("#home").addEventListener("click", function(){
    document.querySelectorAll(".choice").forEach(e => {
        e.classList.add("nodisplay")
    })
    document.querySelector(".home").classList.remove("nodisplay")
})
document.querySelector("#customers-b").addEventListener("click", function(){
    document.querySelectorAll(".choice").forEach(e => {
        e.classList.add("nodisplay")
    })
    document.querySelector(".Customers-plate").classList.remove("nodisplay")
    renderCustomers();
})
document.querySelector("#account-b").addEventListener("click", function(){
    document.querySelectorAll(".choice").forEach(e => {
        e.classList.add("nodisplay")
    })
    document.querySelector(".Accounts-plate").classList.remove("nodisplay")
})

async function renderCustomers(){
    let container = document.querySelector(".cus-grid")
    container.querySelectorAll(".cus-element").forEach(e => {
        e.remove()
    })
    const response = await createFetch("http://localhost:9000/customer", "GET")
    console.log(response);
    let before = document.querySelector(".addnew")
    response.forEach(e => {
        let elem = document.createElement("div")
        elem.innerHTML = `
                <div class="cus-name-delete">X</div>
                <p class="cus-elem-info">name: ${e.name}</p>
                <p class="cus-elem-info">email: ${e.email}</p>
                <p class="cus-elem-info">age: ${e.age}</p>
                <p class="cus-elem-info">accounts: ${e.accounts}</p>
        `
        elem.querySelector(".cus-name-delete").addEventListener("click", async function () {
            let res = await createFetch(`http://localhost:9000/customer/${e.id}`, "DELETE")
            console.log(res);
            if(res){
                elem.remove()
            }
        })
        elem.classList.add("cus-element")
        elem.setAttribute("id", e.id)
        container.insertBefore(elem, before)
    })
}

//модалка ---------------------------
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
        elem.innerHTML = `
                <div class="cus-name-delete">X</div>
                <p class="cus-elem-info">name: ${res.name}</p>
                <p class="cus-elem-info">email: ${res.email}</p>
                <p class="cus-elem-info">age: ${res.age}</p>
                <p class="cus-elem-info">accounts: ${res.accounts}</p>
        `
        elem.querySelector(".cus-name-delete").addEventListener("click", async function () {
            let res2 = await createFetch(`http://localhost:9000/customer/${res.id}`, "DELETE")
            console.log(res2);
            if(res2){
                elem.remove()
            }
        })
        elem.classList.add("cus-element")
        elem.setAttribute("id", res.id)
        container.insertBefore(elem, before)

        document.querySelector(".modal-fon").classList.add("nodisplay")
        document.querySelector(".modal-add-new").classList.add("nodisplay")
    }
    console.log(res);
})

async function deleteCustomer(id){
    console.log(id);
}

//функция отправки запросов ---------------------------------------
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