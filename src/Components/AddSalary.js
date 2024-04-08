import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import './add.css';

const AddSalary = () => {
  // const [employeeData, setEmployeeData] = useState([]);
  // const productId = useParams();
  // const ID = productId["id"];

  const [formData, setFormData] = useState({
    id: 0,
    amount: 0,
    date: '',
    description: '',
  });
  let navigate = useNavigate();
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  let employee = null;
  const handleSubmit = async(e) => {
    e.preventDefault();
    // Placeholder for handling form submission
    await axios.get("http://localhost:9191/employees/"+formData.id.toString()).then(async(response) => {  
      console.log("Adding");
      console.log(response.data);
      employee = response.data
      // navigate(-1);
    }).catch (error => {
      console.log(error);
    });
    
    console.log(employee);
    console.log({employee:employee, amount:formData.amount, description:formData.description, status:0, payment_date:formData.date});
    await axios.post("http://localhost:9191/employeesalaries", {employee:employee, amount:formData.amount, description:formData.description, status:0, payment_date:formData.date}).then((response1) => {
          console.log("Adding");
          console.log(response1.data);

      }).catch(error => {
        console.log(error);
      });

    console.log('Form submitted with data:', formData);
    navigate(-1);
    // You can add your logic for handling the form data here
  };

  return (
    <div>
      <h2>Add new record</h2>
      <form onSubmit={handleSubmit}>
      <label>
          Employee ID:
          <input
            type="number"
            name="id"
            value={formData.id}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Amount:
          <input
            type="number"
            name="amount"
            value={formData.amount}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Description:
          <input
            type="text"
            name="description"
            value={formData.description}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Payment date:
          <input
            type="date"
            name="date"
            value={formData.date}
            onChange={handleChange}
          />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default AddSalary;
