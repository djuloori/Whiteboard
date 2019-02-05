import React from "react";
import Paper from '@material-ui/core/Paper';
import VirtualizedTable from '../framework/VirtualizedTable';

class CoursesPage extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoaded: false
        }
    }
    componentDidMount() {
        fetch('app/Classes/getCourses')
            .then(res => res.json())
            .then(json => {
                this.setState({
                    isLoaded: true,
                    items: json
                })
            })
            .then().catch(e => console.log("error: ", e));
    }
    render() {
        var { isLoaded, items } = this.state;

        return (
            <Paper style={{ height: 400, width: '100%' }}>
                <VirtualizedTable
                    rowCount={items.length}
                    rowGetter={({ index }) => items[index]}
                    onRowClick={event => console.log(event)}
                    columns={[
                        {
                            width: 200,
                            flexGrow: 0.5,
                            label: 'Class ID',
                            dataKey: 'classId',
                            numeric: true
                        },
                        {
                            width: 120,
                            flexGrow: 0.5,
                            label: 'Class Name',
                            dataKey: 'className',
                        }
                    ]}
                />
            </Paper>
        );
    }
}

export default CoursesPage;