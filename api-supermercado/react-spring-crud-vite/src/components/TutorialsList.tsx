import { useEffect, useState } from "react"
import { Link } from "react-router-dom"
import TutorialDataService from "../api/services/products"
import { ProductModel } from "../models/tutorials"

const TutorialsList = () => {
  const [tutorials, setTutorials] = useState([] as ProductModel[])
  const [currentTutorial, setCurrentTutorial] = useState(null as ProductModel | null)
  const [currentIndex, setCurrentIndex] = useState(-1 as number)
  const [searchTitle, setSearchTitle] = useState(0 as number)

  useEffect(() => {
    retrieveTutorials()
  }, [])

  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const onChangeSearchTitle = (e: { target: { value: any } }) => {
    const searchTitle = e.target.value
    setSearchTitle(searchTitle)
  }

  const retrieveTutorials = () => {
    TutorialDataService.getAll()
      .then(response => {
        setTutorials(response.data)
        console.log(response.data)
      })
      .catch(e => {
        console.log(e)
      })
  }

  const refreshList = () => {
    retrieveTutorials()
    setCurrentTutorial(null)
    setCurrentIndex(-1)
  }

  const setActiveTutorial = (tutorial: ProductModel, index: number) => {
    setCurrentTutorial(tutorial)
    setCurrentIndex(index)
  }

  const removeAllTutorials = () => {
    TutorialDataService.removeAll()
      .then(response => {
        console.log(response.data)
        refreshList()
      })
      .catch(e => {
        console.log(e)
      })
  }

  const findByTitle = () => {
    TutorialDataService.get(searchTitle)
      .then(response => {
        setTutorials(response.data)
        console.log(response.data)
      })
      .catch(e => {
        console.log(e)
      })
  }
  return (
    <div className="list row">
      <div className="col-md-8">
        <div className="input-group mb-3">
          <input
            type="text"
            className="form-control"
            placeholder="Busca por ID"
            value={searchTitle}
            onChange={onChangeSearchTitle}
          />
          <div className="input-group-append">
            <button
              className="btn btn-outline-secondary"
              type="button"
              onClick={findByTitle}
            >
              Search
            </button>
          </div>
        </div>
      </div>
      <div className="col-md-6">
        <h4>Tutorials List</h4>

        <ul className="list-group">
          {tutorials &&
            tutorials.map((tutorial, index) => (
              <li
                className={
                  "list-group-item " + (index === currentIndex ? "active" : "")
                }
                onClick={() => setActiveTutorial(tutorial, index)}
                key={index}
              >
                {tutorial.idproducto}
              </li>
            ))}
        </ul>

        <button
          className="m-3 btn btn-sm btn-danger"
          onClick={removeAllTutorials}
        >
          Remove All
        </button>
      </div>
      <div className="col-md-6">
        {currentTutorial ? (
          <div>
            <h4>Tutorial</h4>
            <div>
              <label>
                <strong>Nombre:</strong>
              </label>{" "}
              {currentTutorial.nombre}
            </div>
            <div>
              <label>
                <strong>Categoria:</strong>
              </label>{" "}

              {currentTutorial.categoria.categoria}
            </div>
            <div>
              <label>
                <strong>Precio:</strong>
              </label>{" "}
              {currentTutorial.precio}
            </div>

            <Link
              to={"/tutorials/" + currentTutorial.idproducto}
              className="badge badge-warning"
            >
              Edit
            </Link>
          </div>
        ) : (
          <div>
            <br />
            <p>Please click on a Tutorial...</p>
          </div>
        )}
      </div>
    </div>
  )
}

export default TutorialsList