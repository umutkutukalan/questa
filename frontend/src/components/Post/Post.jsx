import {
  Avatar,
  Card,
  CardActions,
  CardContent,
  CardHeader,
  Collapse,
  IconButton,
  Typography,
} from "@mui/material";
import { red } from "@mui/material/colors";
import FavoriteIcon from "@mui/icons-material/Favorite";
import CommentIcon from "@mui/icons-material/Comment";
import { Link } from "react-router-dom";
import { useState } from "react";

const Post = (props) => {
  const { title, text, userId, username } = props;
  const [liked, setLiked] = useState(false);

  const handleLike = () => {
    setLiked(!liked);
  };


  return (
    <Card sx={{ width: 400 }}>
      <CardHeader
        avatar={
          <Link to={{ pathname: "/users/" + userId }}>
            <Avatar sx={{ bgcolor: red[500] }} aria-label="recipe">
              {username.charAt(0).toUpperCase()}
            </Avatar>
          </Link>
        }
        action={<IconButton aria-label="settings"></IconButton>}
        title={title}
        subheader="September 14, 2016"
      />
      <CardContent>
        <Typography variant="body2" sx={{ color: "text.secondary" }}>
          {text}
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="add to favorites" onClick={handleLike}>
          <FavoriteIcon style={liked ? { color: "red" } : null} />
        </IconButton>
        <IconButton aria-label="show more">
          <CommentIcon />
        </IconButton>
      </CardActions>
      <Collapse timeout="auto" unmountOnExit>
        <CardContent>
          <Typography sx={{ marginBottom: 2 }}>Method:</Typography>
          <Typography sx={{ marginBottom: 2 }}>
            Heat 1/2 cup of the broth in a pot until simmering, add saffron and
            set aside for 10 minutes.
          </Typography>
          <Typography sx={{ marginBottom: 2 }}>
            Heat oil in a (14- to 16-inch) paella pan or a large, deep skillet
            over medium-high heat. Add chicken, shrimp and chorizo, and cook,
            stirring occasionally until lightly browned, 6 to 8 minutes.
            Transfer shrimp to a large plate and set aside, leaving chicken and
            chorizo in the pan. Add pimentón, bay leaves, garlic, tomatoes,
            onion, salt and pepper, and cook, stirring often until thickened and
            fragrant, about 10 minutes. Add saffron broth and remaining 4 1/2
            cups chicken broth; bring to a boil.
          </Typography>
          <Typography sx={{ marginBottom: 2 }}>
            Add rice and stir very gently to distribute. Top with artichokes and
            peppers, and cook without stirring, until most of the liquid is
            absorbed, 15 to 18 minutes. Reduce heat to medium-low, add reserved
            shrimp and mussels, tucking them down into the rice, and cook again
            without stirring, until mussels have opened and rice is just tender,
            5 to 7 minutes more. (Discard any mussels that don&apos;t open.)
          </Typography>
          <Typography>
            Set aside off of the heat to let rest for 10 minutes, and then
            serve.
          </Typography>
        </CardContent>
      </Collapse>
    </Card>
  );
};

export default Post;
