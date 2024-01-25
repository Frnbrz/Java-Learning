import { useState } from "react"
import ProductsDataService from "../api/services/products"
import { ProductModel } from "../models/tutorials"

const AddTutorial = () => {
  const initialTutorialState = {
    idproducto: 0,
    categoria: "",
    medida: "",
    precio: 0,
    stock: 0,
  }
  const [tutorial, setTutorial] = useState(initialTutorialState)
  const [submitted, setSubmitted] = useState(false)

  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const handleInputChange = (event: { target: { name: any; value: any } }) => {
    const { name, value } = event.target
    setTutorial({ ...tutorial, [name]: value })
  }

  const saveTutorial = () => {
    const data = {
      idproducto: tutorial.idproducto,
      categoria: tutorial.categoria,
      medida: tutorial.medida,
      precio: tutorial.precio,
      stock: tutorial.stock,
    } as ProductModel

    ProductsDataService.create(data)
      .then(response => {
        setTutorial({
          idproducto: response.data.idproducto,
          categoria: response.data.categoria,
          medida: response.data.medida,
          precio: response.data.precio,
          stock: response.data.stock,
        })
        setSubmitted(true)
        console.log(response.data)
      })
      .catch(e => {
        console.log(e)
      })
  }

  const newTutorial = () => {
    setTutorial(initialTutorialState)
    setSubmitted(false)
  }

  return (
    <div className="submit-form">
      {submitted ? (
        <div>
          <h4>You submitted successfully!</h4>
          <button className="btn btn-success" onClick={newTutorial}>
            Add
          </button>
        </div>
      ) : (
        <div>
          <div className="form-group">
            <label htmlFor="title">Title</label>
            <input
              type="text"
              className="form-control"
              id="title"
              required
              value={tutorial.categoria}
              onChange={handleInputChange}
              name="title"
            />
          </div>

          <div className="form-group">
            <label htmlFor="description">Description</label>
            <input
              type="text"
              className="form-control"
              id="description"
              required
              value={tutorial.stock}
              onChange={handleInputChange}
              name="description"
            />
          </div>

          <button onClick={saveTutorial} className="btn btn-success">
            Submit
          </button>
        </div>
      )}
    </div>
  )
}

export default AddTutorial