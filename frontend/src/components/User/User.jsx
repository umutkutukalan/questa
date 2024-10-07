import { useParams } from "react-router-dom"

const User = () => {

    const {userId} = useParams();

  return (
    <div>
        <h2 className="text-2xl text-center">
            User = {userId}
        </h2>
    </div>
  )
}

export default User