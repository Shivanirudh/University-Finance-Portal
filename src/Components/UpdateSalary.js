import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';
import './add.css';


const UpdateSalary = () => {
  const [formData, setFormData] = useState({
    amount: '',
    description: '',
  });

  const productId = useParams();
  const id = productId["id"];
  let navigate = useNavigate();

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  let employeeSal = null;
  const handleSubmit = async(e) => {
    e.preventDefault();
    // Placeholder for handling form submission
    await axios.get("http://localhost:9191/employeesalaries/"+id.toString()).then(async(response) => {  
      console.log("Updating");
      console.log(response.data);
      employeeSal = response.data
    }).catch (error => {
      console.log(error);
    });
    
    console.log(employeeSal);
    // console.log({amount:formData.amount, description:formData.description, status:0, payment_date:formData.date});
    
    employeeSal.amount = formData.amount; employeeSal.description = formData.description;employeeSal.payment_date = formData.date
    console.log(employeeSal)
    await axios.put("http://localhost:9191/employeesalaries/"+id.toString(), employeeSal).then((response1) => {
          console.log("Updating");
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
      <h2>Update Record</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Amount:
          <input
            type="text"
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

export default UpdateSalary;
