import React from 'react';
import Login from './Login';
import SignUp from './SignUp';
import { HashRouter, Route } from 'react-router-dom';

class App extends React.Component {
    render() {
        return (
            <HashRouter>
                <div>
                    <Route exact path='/' component={Login} />
                    <Route path="/SignUp" component={SignUp} />
                </div>
            </HashRouter>
        );
    }
}

export default App;