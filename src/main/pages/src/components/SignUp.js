import React from 'react';
import '../css/Login.css';
import 'bootstrap/dist/css/bootstrap.min.css';

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
                <div className="card">
                    <div className="card-header">
                        <h3>Sign Up</h3>
                    </div>
                    <div className="card-body">
                        <form>
                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><i className="glyphicon glyphicon-user"></i></span>
                                </div>
                                <input type="text" className="form-control" placeholder="First Name"/>

                            </div>

                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><i className="glyphicon glyphicon-key"></i></span>
                                </div>
                                <input type="text" className="form-control" placeholder="Last Name"/>
                            </div>

                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><i className="glyphicon glyphicon-key"></i></span>
                                </div>
                                <input type="email" className="form-control" placeholder="Email"/>
                            </div>

                            <div className="input-group form-group">
                                <div className="input-group-prepend">
                                    <span className="input-group-text"><i className="glyphicon glyphicon-key"></i></span>
                                </div>
                                <input type="password" className="form-control" placeholder="Password"/>
                            </div>

                            <div className="row align-items-center remember">
                                <input type="checkbox"/>Already have an account
                            </div>
                            <div className="form-group">
                                <input type="submit" value="Login" className="btn float-right login_btn"/>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            </body>
        );
    }

}
export default SignUp;