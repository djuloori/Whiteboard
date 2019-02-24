import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import grey from '@material-ui/core/colors/grey';
import red from '@material-ui/core/colors/red';
import orange from '@material-ui/core/colors/orange';
import Zoom from '@material-ui/core/Zoom';

const styles = theme => ({
    margin: {
        margin: theme.spacing.unit,
        marginTop: theme.spacing.unit * 3,
    },
    cssRoot: {
        borderRadius: '10px',
        border: '1px solid black',
        color: theme.palette.getContrastText(grey[50]),
        backgroundColor: grey[50],
        '&:hover': {
            color: theme.palette.getContrastText(red[500]),
            border: '1px solid red',
            backgroundColor: red[500],
            fontWeight: 'bold',
            boxShadow: '0 0 10px red, 0 0 5px darkred',

        },
    },
    cssSelect: {
        borderRadius: '10px',
        border: '1px solid orange',
        color: theme.palette.getContrastText(orange[300]),
        backgroundColor: orange[300],
        boxShadow: '0 0 10px orange, 0 0 5px darkorange',
        '&:hover': {
            color: theme.palette.getContrastText(red[500]),
            border: '1px solid red',
            backgroundColor: red[500],
            fontWeight: 'bold',
            boxShadow: '0 0 10px red, 0 0 5px darkred',
        },
    },
});

class DeleteButton extends React.PureComponent {
    constructor(props) {
        const { classes } = props;
        super(props);
        this.state = {
            itemCount: 'All',
            buttonStyle: classes.cssRoot,
        };

    }
    componentDidUpdate() {
        const { classes } = this.props;
        var item = this.props.selectedIndex;
        if (item.length === 0) {
            this.setState({itemCount: 'All', buttonStyle: classes.cssRoot});
        } else {
            this.setState({itemCount: item.length, buttonStyle: classes.cssSelect });
        }
    }

    render() {
        const { classes } = this.props;
        return (
            <Zoom in={this.props.isEditOn} >
                <Button
                    variant="contained"
                    className={this.state.buttonStyle + ' ' + classes.margin}
                    onClick={this.props.onClick}
                >
                    DELETE {this.state.itemCount}
                </Button>
            </Zoom>
        );
    }
}

DeleteButton.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(DeleteButton);