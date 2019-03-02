import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import grey from '@material-ui/core/colors/grey';
import Zoom from '@material-ui/core/Zoom';

const styles = theme => ({
    margin: {
        margin: theme.spacing.unit,
        marginTop: theme.spacing.unit * 3,
    },
    cssRoot: {
        float: 'right',
        borderRadius: '10px',
        border: '1px solid black',
        color: theme.palette.getContrastText(grey[50]),
        backgroundColor: grey[50],
        '&:hover': {
            color: theme.palette.getContrastText('#689f38'),
            border: '1px solid green',
            backgroundColor: '#689f38',
            fontWeight: 'bold',
            boxShadow: '0 0 10px green, 0 0 5px darkgreen',

        },
    },
});

class AddButton extends React.PureComponent {
    constructor(props) {
        const { classes } = props;
        super(props);
        this.state = {
            buttonStyle: classes.cssRoot,
        };

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
                    Add Item
                </Button>
            </Zoom>
        );
    }
}

AddButton.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(AddButton);