import { useEffect, useState } from "react";

const Post = () => {
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
      <ul>
        {postList.map((post) => (
          <li key={post.id}>
            {post.title} {post.text}
          </li>
        ))}
      </ul>
    );
  }
};

export default Post;
