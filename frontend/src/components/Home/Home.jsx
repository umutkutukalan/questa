
import { useEffect, useState } from "react";
import Post from "../Post/Post";
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
      <div className="flex items-center flex-col">
        <h1 className="text-2xl text-center">Home!</h1>
        {postList.map((post, index) => (
          <Post key={index} title={post.title} text={post.text}></Post>
        ))}
      </div>
    );
  }
};

export default Home;
