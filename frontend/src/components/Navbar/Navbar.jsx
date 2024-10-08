import { Link } from "react-router-dom";
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';

const Navbar = () => {
  let userId = 5;
  return (
    <div>
      <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
          <Link to="/">Home</Link>
          </Typography>
          <Link to={{ pathname: "/users/" + userId }}>User</Link>
        </Toolbar>
      </AppBar>
    </Box>
      <ul>
        <li className="flex items-center justify-around mb-20 mt-5 text-2xl">
          
          
        </li>
      </ul>
    </div>
  );
};

export default Navbar;
