import React from 'react';
import '../css/Login.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { NavLink } from 'react-router-dom';

class LoginPage extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            username: '',
            password: ''
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(){
        this.props.onSubmit(this.state.username,this.state.password);
    }

    render(){
        return (
            <div className="container-box">
                <div className="card">
                    <div className="card-header">
                        <h3>Sign In</h3>
                    </div>
                    <div className="card-body">
                        <form>
                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><i className="glyphicon glyphicon-user"></i></span>
                                </div>
                                <input type="text" className="form-control" placeholder="username" onChange={(event) => this.setState({username:event.target.value})}/>

                            </div>
                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><i className="glyphicon glyphicon-key"></i></span>
                                </div>
                                <input type="password" className="form-control" placeholder="password" onChange={(event) => this.setState({password:event.target.value})}/>
                            </div>
                            <div className="row align-items-center remember">
                                <input type="checkbox"/>Remember Me
                            </div>
                            <div className="form-group">
                                <input type="submit" value="Login" onClick={this.handleChange} className="btn float-right login_btn"/>
                            </div>
                        </form>
                    </div>
                    <div className="card-footer">
                        <div className="d-flex justify-content-center links">
                            Don't have an account?<NavLink exact to = "/SignUp" activeClassName='active-link'>Sign Up</NavLink>
                        </div>
                        <div className="d-flex justify-content-center">
                            <a href="#">Forgot your password?</a>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
export default LoginPage;