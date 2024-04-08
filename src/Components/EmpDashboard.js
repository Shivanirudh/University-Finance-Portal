import React, { useEffect, useState } from 'react';
import './dashboard.css';
import { useNavigate, useParams} from 'react-router-dom';
import EmpSalaries from './EmpSalaries';


const EmployeeDashboard = () => {
    const [employeeData, setEmployeeData] = useState([]);
    const productId = useParams();
    const id = productId["id"]
    console.log(productId, id);
    // console.log('http://localhost:9191/employees/'+id.toString())
    let navigate = useNavigate();
    useEffect(() => {
        fetch('http://localhost:9191/employees/'+id.toString())
          .then(response => response.json())
          .then(data => setEmployeeData(data));
      }, []);
      console.log(employeeData);
    const handleLogout = () => {
      // Placeholder for logout logic
      navigate("/");
      console.log('User logged out');
      // You can add your logout logic here, such as redirecting to the login page
    };
  
    return (
      <div className='dashboard'>
        <nav>
          <h2>Employee Dashboard</h2>
          <button className="logout" onClick={handleLogout}>Logout</button>
        </nav>
        <div className="employee-info">
          <h1>Welcome, {employeeData.first_name} {employeeData.last_name}!</h1>
          <p>Position: {employeeData.title}</p>
          <p>Department: {employeeData.department && employeeData.department.name}</p>
          <p>Email: {employeeData.email}</p>
        </div>
            {employeeData.department && employeeData.department.name === "Accounts"
                && <EmpSalaries/>}

      </div>
    );
  };
  
  export default EmployeeDashboard;