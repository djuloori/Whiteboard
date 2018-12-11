import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/Login.css';
import { NavLink } from 'react-router-dom';
import AccountCircle from '@material-ui/icons/AccountCircle';
import VpnKey from '@material-ui/icons/VpnKey'

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
                <div className="d-flex justify-content-center title">
                    <h1>Whiteboard</h1>
                </div>
                <div className="card">
                    <div className="card-header">
                        <h3>Sign In</h3>
                    </div>
                    <div className="card-body">
                        <form>
                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><AccountCircle className="user_icon"></AccountCircle></span>
                                </div>
                                <input type="text" className="form-control" placeholder="Username" onChange={(event) => this.setState({username:event.target.value})}/>

                            </div>
                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><VpnKey className="key_icon"></VpnKey></span>
                                </div>
                                <input type="password" className="form-control" placeholder="Password" onChange={(event) => this.setState({password:event.target.value})}/>
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
                        <div className="d-flex justify-content-center links account-text">
                            Don't have an account?&nbsp;<NavLink exact to = "/SignUp" className='signup-link'>Sign Up</NavLink>
                        </div>
                        <div className="d-flex justify-content-center">
                            <a className='forgotpass-link' href="#">Forgot your password?</a>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
export default LoginPage;