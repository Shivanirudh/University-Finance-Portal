import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './empSalary.css';
import { useNavigate, useParams } from 'react-router-dom';

const EmpSalaries = () => {
    const [employeeSal, setEmployeeSal] = useState([]);
    const [selectedEmployees, setSelectedEmployees] = useState([]);
    const navigate = useNavigate();
    const productId = useParams();
    const ID = productId["id"];

    const handleEmployeeSelect = (employeeId) => {
        // Toggle employee selection
        setSelectedEmployees((prevSelected) =>
        prevSelected.includes(employeeId)
            ? prevSelected.filter((id) => id !== employeeId)
            : [...prevSelected, employeeId]
        );
    };
    const handleDisburseSalary = async(e) => {
        // Placeholder for disburse salary logic
        // e.preventDefault();
        console.log('Disbursing salary to selected employees:', selectedEmployees);
        selectedEmployees.forEach(
            async(id)=>{
                await axios.put("http://localhost:9191/employeesalaries/flip/"+id.toString()).then((response) => {  
                    console.log("Flipping");
                    console.log(response.data);
                    window.location.reload();
                  }).catch (error => {
                    console.log(error);
                  });
            }
        );
        // window.location.reload();

        // You can add your disburse salary logic here
    };

    const handleModifyRecord = () => {
        // Placeholder for modify record logic
        navigate("/employee/update/"+selectedEmployees[0].toString());
        console.log('Modifying record for selected employee:', selectedEmployees[0]);
        // You can add your modify record logic here
      };

      const handleAddRecord = () => {
        navigate("/employee/"+ID.toString()+"/add");
        // Placeholder for modify record logic
        console.log('Adding new record');
        // You can add your modify record logic here
      };  

      const handleDeleteRecord = async(e) => {
        
        // Placeholder for modify record logic
        console.log('Deleting selected record: ', selectedEmployees[0]);
        await axios.delete("http://localhost:9191/employeesalaries/"+selectedEmployees[0].toString()).then((response) => {  
            console.log("Deleting");
            console.log(response);
            window.location.reload();
        }).catch (error => {
            console.log(error);
        });

        // You can add your modify record logic here
      };  
    useEffect(() => {
        fetch('http://localhost:9191/employeesalaries/all')
          .then(response => response.json())
          .then(data => setEmployeeSal(data));
      }, []);

      const isDisburseButtonActive = selectedEmployees.length > 0;
      const isModifyButtonActive = selectedEmployees.length === 1;
      const isDeleteButtonActive = selectedEmployees.length === 1;  
    return (
        <div>
            <table>
                <thead>
                <tr>
                    <th>Select</th>
                    <th>Employee ID</th>
                    <th>Name</th>
                    <th>Title</th>
                    <th>Amount</th>
                    <th>Description</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                {employeeSal.map((employee) => (
                    <tr key={employee.id}>
                    <td>
                        <label>
                        <input
                            type="checkbox"
                            checked={selectedEmployees.includes(employee.id)}
                            onChange={() => handleEmployeeSelect(employee.id)}
                        />
                        </label>
                    </td>
                    
                    <td>{employee.employee.employee_id}</td>
                    <td>{employee.employee.first_name} {employee.employee.last_name}</td>
                    <td>{employee.employee.title}</td>
                    <td>${employee.amount}</td>
                    <td>{employee.description}</td>
                    <td>{employee.status}</td>
                    </tr>
                ))}
                </tbody>
            </table>
            <button onClick={handleDisburseSalary} disabled={!isDisburseButtonActive}>
                Disburse Salary
            </button>
            <button onClick={handleModifyRecord} disabled={!isModifyButtonActive}>
                Modify Record
            </button>
            <button onClick={handleAddRecord}>
                Add Record
            </button>
            <button onClick={handleDeleteRecord}  disabled={!isDeleteButtonActive}>
                Delete Record
            </button>
        </div>
    );
};

export default EmpSalaries;