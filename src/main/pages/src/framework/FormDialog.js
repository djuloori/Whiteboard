import React from 'react';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import PropTypes from "prop-types";
import {withStyles} from "@material-ui/core";
import orange from "@material-ui/core/colors/orange";
import red from "@material-ui/core/colors/red";
import axios from 'axios';

const styles = theme => ({
    cssLabel: {
        '&$cssFocused': {
            fontWeight: 'bold',
            color: orange[500]
        },
    },

    cssFocused: {},

    cssOutlinedInput: {
        '&$cssFocused $notchedOutline': {
            borderColor: orange[500],
        },
    },
    notchedOutline: {},

    margin: {
        margin: theme.spacing.unit,
        marginTop: theme.spacing.unit * -2,
    },

    cssCancel: {
        float: 'right',
        borderRadius: '10px',
        '&:hover': {
            color: theme.palette.getContrastText(red[500]),
            border: '1px solid red',
            backgroundColor: red[500],
            fontWeight: 'bold',
            boxShadow: '0 0 10px red, 0 0 5px darkred',

        },
    },

    cssSubmit: {
        float: 'right',
        borderRadius: '10px',
        '&:hover': {
            color: theme.palette.getContrastText('#689f38'),
            border: '1px solid green',
            backgroundColor: '#689f38',
            fontWeight: 'bold',
            boxShadow: '0 0 10px green, 0 0 5px darkgreen',

        },
    },
});

class FormDialog extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            open: false,
            textField: {}
        };
        this.props.handleFormOn(false);
    }

    static getDerivedStateFromProps(props, state) {
        if (props.isFormOn !== state.open) {
            return {
                open: props.isFormOn,
            };
        }
        return null;
    }

    handleChangeFor = (propertyName) => (event) => {
        const { textField } = this.state;
        const newTextField = {
            ...textField,
            [propertyName.dataKey]: event.target.value
        };
        this.setState({ textField: newTextField });
    };

    handleCancel = () => {
        const off = false;
        this.setState({ open: off });
        this.props.handleFormOn(off);
    };

    handleSubmit = () => {
        const { fields, addCourseUrl } = this.props;
        const textFieldJson = this.state.textField;
        {fields.map(({ dataKey }) => {
            console.log(textFieldJson[dataKey]);
        })}
        axios.put(addCourseUrl,{}
            //textFieldJson
        ).then(res => {
            console.log(res);
        }).catch(error => {
            console.log(error);
        });

    };

    render() {
        const { classes, fields, dialogTitle, dialogContent } = this.props;
        return (
            <Dialog
                open={this.state.open}
                onClose={this.handleClose}
                aria-labelledby="form-dialog-title"
            >
                <DialogTitle id="form-dialog-title">{dialogTitle}</DialogTitle>
                <DialogContent>
                    <DialogContentText>
                        {dialogContent}
                    </DialogContentText>
                    {fields.map(({ label, dataKey, type }, index) => {
                        return (
                            <TextField
                                InputLabelProps={{
                                    classes: {
                                        root: classes.cssLabel,
                                        focused: classes.cssFocused,
                                    },
                                }}
                                InputProps={{
                                    classes: {
                                        root: classes.cssOutlinedInput,
                                        focused: classes.cssFocused,
                                        notchedOutline: classes.notchedOutline,
                                    },
                                }}
                                margin='normal'
                                variant='outlined'
                                key={dataKey}
                                label={label}
                                type={type}
                                fullWidth
                                onChange={this.handleChangeFor({dataKey})}
                            />
                        );
                    })}

                </DialogContent>
                <DialogActions>
                    <Button
                        onClick={this.handleCancel}
                        className={classes.cssCancel + ' ' + classes.margin}
                    >
                        Cancel
                    </Button>
                    <Button
                        onClick={this.handleSubmit}
                        className={classes.cssSubmit + ' ' + classes.margin}
                    >
                        Submit
                    </Button>
                </DialogActions>
            </Dialog>
        );
    }
}

FormDialog.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(FormDialog);