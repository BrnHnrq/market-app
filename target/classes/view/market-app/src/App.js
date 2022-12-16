import { useEffect, useState } from 'react';
import './App.css';

const url = "http://localhost:8080/api/products"

function App() {

  const [products, setProducts] = useState([]);
  const [isOpen, setIsOpen] = useState()

  const [method, setMethod] = useState()

  const get = async () =>{
    let response = await fetch(url);
    let data = await response.json()
    setProducts(data)
    console.log(products)
  }

  const deleteProduct = async(id) =>{
    await fetch(url + "/" + id, {
      method:"DELETE"
    });
    await window.location.reload(false);
  }

  useEffect(() =>{
    get();
  },[])

  const saveProduct = async body =>{
    await fetch(url, {
      method:"POST",
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(body)
    })

    await window.location.reload(false);
  }

  const update = async (object) =>{
    await setIsOpen(true)
    document.getElementById("productId").value = object.id
    document.getElementById("brand").value = object.productBrand
    document.getElementById("name").value = object.productName
    document.getElementById("cost").value = object.productCost
    document.getElementById("quantity").value = object.productQuantity
    document.getElementById("category").value = object.productCategory
  }

  const formHtml = (isOpen) =>{

    const submit = event =>{

      event.preventDefault();
      
      console.log("aaa")

      let product = (
        {
          id: document.getElementById("productId").value,
          productBrand: document.getElementById("brand").value,
          productName: document.getElementById("name").value,
          productCost: document.getElementById("cost").value,
          productQuantity: document.getElementById("quantity").value,
          productType: document.getElementById("category").value
        }
      )

      saveProduct(product)
    }

    if(!isOpen) return null

    return(
      
        <form onSubmit={submit}>
          <div className='form'>
            <input hidden id="productId"></input>
            <label >Marca</label>
            <input required type="text" id="brand"></input>

            <label>Nome do produto</label>
            <input required type="text" id="name"></input>

            <label>Preço</label>
            <input required type="number" id="cost"></input>

            <label>Quantidade em estoque</label>
            <input required type="number" id="quantity"></input>
            
            <label>Categoria</label>
            <select required id="category">
              <option value="ALIMENTO">Alimento</option>
              <option value="DOMESTICO">Doméstico</option>
              <option value="HIGIENE">Higiene</option>
              <option value="BEBIDA">Bebida</option>
            </select>

            <button>Adicionar</button>
          </div>
        </form>
      
    )
  }

  return (
    <div className="App">
      <main className='main'>
        <h1>Produtos</h1>
        <li>
          {
            products.map((data) => (
              <div className='items' key={data.id}>
                <p> {"Marca: " + data.productBrand} </p>
                <p> {"Nome: " + data.productName} </p>
                <p> {"Custo: " + data.productCost} </p>
                <p> {"Quantidade em estoque: " + data.productQuantity} </p>
                <p> {"Tipo: " + data.productType} </p>
                <button onClick={() => update(data)}>Update</button>
                <button onClick={() => deleteProduct(data.id)} className="delete">X</button>
              </div>
            ))
          }
          <button className='add-product' onClick={() => {isOpen ? setIsOpen(false) : setIsOpen(true)}}>Adicionar</button>
           {formHtml(isOpen)}
        </li>
       
      </main>
    </div>
  );
}

export default App;
