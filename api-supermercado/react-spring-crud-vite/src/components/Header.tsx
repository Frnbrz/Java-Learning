import { Link } from "react-router-dom"

function Header() {
  return (
    <nav className="navbar navbar-expand navbar-light bg-light px-4">
      <Link to={"/tutorials"} className="navbar-brand">
        App
      </Link>
      <div className="navbar-nav mr-auto">
        <li className="nav-item">
          <Link to={"/tutorials"} className="nav-link">
            Tutorials
          </Link>
        </li>
        <li className="nav-item">
          <Link to={"/add"} className="nav-link">
            Add
          </Link>
        </li>
      </div>
    </nav>
  )
}

export default Header