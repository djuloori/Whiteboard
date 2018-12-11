import React from 'react';
import Email from '@material-ui/icons/Email';
import Lock from '@material-ui/icons/Lock';

import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/Login.css';
import {NavLink} from "react-router-dom";


class SignUp extends React.Component {
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
            <body>
            <div className="container-box">
                <div className="d-flex justify-content-center title">
                    <h1>Whiteboard</h1>
                </div>
                <div className="card">
                    <div className="card-header">
                        <h3>Sign Up</h3>
                    </div>
                    <div className="card-body">
                        <form>
                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><Email className="user_icon"></Email></span>
                                </div>
                                <input type="text" className="form-control" placeholder="Email "/>

                            </div>

                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><Lock className="user_icon"></Lock></span>
                                </div>
                                <input type="text" className="form-control" placeholder="Password"/>
                            </div>

                            <div className="row align-items-center type">
                                <div className="radio">
                                    <label><input type="radio" name="optradio"/>&nbsp;Professor</label>
                                </div>
                                <div className="radio">
                                    <label><input type="radio" name="optradio"/>&nbsp;Student</label>
                                </div>
                            </div>
                            <div className="form-group">
                                <input type="submit" value="Register" className="btn float-right register_btn"/>
                            </div>
                        </form>
                    </div>
                    <div className="card-footer">
                        <div className="d-flex justify-content-center links account-text">
                            Already have an account?&nbsp;<NavLink exact to = "/" className='login-link'>Login In</NavLink>
                        </div>
                    </div>
                </div>

            </div>
            </body>
        );
    }

}
export default SignUp;