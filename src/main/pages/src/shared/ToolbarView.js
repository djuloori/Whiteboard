import React from 'react';
import Topbar from '../framework/TopBar';
import Sidebar from '../framework/SideBar';

class ToolbarView extends React.Component {
    constructor() {
        super();
        this.state = {
            open: false,
        };
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick() {
        this.setState({
            open: !this.state.open,
        })
    }

    render() {
        return (
            <div>
                <Topbar handleClick={this.handleClick}/>
                <Sidebar active={this.state.open}/>
            </div>
        );
    }
}

export default ToolbarView;