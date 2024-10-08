import { useEffect, useState } from "react";
import Post from "../Post/Post";
import { Container } from "@mui/material";
import { Box } from "@mui/material";
const Home = () => {
  const [error, setError] = useState(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [postList, setPostList] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/posts")
      .then((res) => res.json())
      .then(
        (result) => {
          setIsLoaded(true);
          setPostList(result);
        },
        (error) => {
          setIsLoaded(true);
          setError(error);
        }
      );
  }, []);

  if (error) {
    return <div>Error!.</div>;
  } else if (!isLoaded) {
    return <div>Loading..</div>;
  } else {
    return (
      <Container>
        <Box sx={{ bgcolor: "#cfe8fc", height: "100%", padding: 5 }}>
          <div className="flex items-center flex-col">
            <ul className="flex flex-col items-align">
              {postList.map((post) => (
                <li key={post.id} className="mt-5">
                  <Post
                    title={post.title}
                    text={post.text}
                    userId={post.userId}
                    username={post.username}
                  ></Post>
                </li>
              ))}
            </ul>
          </div>
        </Box>
      </Container>
    );
  }
};

export default Home;
