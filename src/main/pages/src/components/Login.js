import React from 'react';

class Login extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            username: '',
            password: ''
        };
    }

    render(){
        return (
          <div>
              <h1>Demo Login Form using ReactJS</h1>
              <input type = "text" name = "username" placeHolder="Username" required/>
              <hr></hr>
              <input type = "password" name = "password" placeholder="Password" required/>
              <hr></hr>
              <button onClick={() => this.handleClick()}>Sign In!</button>
          </div>
        );
    }

}
export default Login;