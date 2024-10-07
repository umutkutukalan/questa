import { Link } from "react-router-dom";

const Navbar = () => {
  let userId = 5;
  return (
    <div>
      <ul>
        <li className="flex items-center justify-around mb-20 mt-5 text-2xl">
          <Link to="/">Home</Link>
          <Link to={{ pathname: "/users/" + userId }}>User</Link>
        </li>
      </ul>
    </div>
  );
};

export default Navbar;
