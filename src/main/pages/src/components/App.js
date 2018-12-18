import React from 'react';
import Login from './Login';
import SignUp from './SignUp';
import ToolBar from '../shared/ToolbarView'
import { HashRouter, Route } from 'react-router-dom';

class App extends React.Component {
    render() {
        return (
            <HashRouter>
                <div>
                    <Route exact path='/' component={Login} />
                    <Route path="/SignUp" component={SignUp} />
                    <Route path="/ToolBar" component={ToolBar}/>
                </div>
            </HashRouter>
        );
    }
}

export default App;