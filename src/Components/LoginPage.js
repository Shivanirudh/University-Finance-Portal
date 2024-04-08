import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {
  // State for storing the username and password
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  let navigate = useNavigate();

  // Function to handle form submission
  const handleLogin = async (e) => {
    e.preventDefault();
    // You can add your authentication logic here
    console.log('Username:', username);
    console.log('Password:', password);

    await axios.post("http://localhost:9191/employees/login", null, {params:{
        email: username,
        password: password
      }}).then((response) => {  
        console.log(response.data);
        // if(response.data.length>0){
        //   <Redirect to={`/employee/${response.data}}`/>
        // }
        if(response.data){
          navigate(`/employee/${response.data}`);
        }
        else{
          console.log("Invalid username or password");

          // navigate("/");
          window.location.reload();

        }
      }).catch (error => {
        console.log(error);
      });
  };

  return (
    <div>
      <h1>Login Page</h1>
      <form onSubmit={handleLogin}>
        <label>
          Email ID:
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
          />
        </label>
        <br />
        <label>
          Password:
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
          />
        </label>
        <br />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default LoginPage;
