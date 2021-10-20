// empTableData=[];
// empByID = [];
// function addEmp(F_empID, F_empName, F_empContact, F_empEmail){
//     let Employee = class{
//         constructor(empID, empName, empContact, empEmail){
//             this.empID = empID;
//             this.empName = empName;
//             this.empContact = empContact;
//             this.empEmail = empEmail;
//         }
//     }
//     emp = new Employee(F_empID, F_empName, F_empContact, F_empEmail);

//     fetch('http://localhost:8080/employee/add',{
// 	        method:'POST',
// 	        headers:{
// 	            "Content-Type":"application/json"
// 	        },
// 	        body:JSON.stringify(emp)
// 	    })
// 		.then(response=>{
// 	        ////console.log(response);
// 	        if(response.status===201){
//                 document.getElementById('status').innerHTML = "<b>Successful</b>";
// 	            return response.json();
//             }
// 	        else if(response.status===409){
//                 document.getElementById('status').innerHTML = "Employee Already exists";
// 	            return Promise.reject('Employee Already exists');
// 	        }
//             else if(response.status === 400 ){
//                 document.getElementById('status').innerHTML = "BAD REQUEST";
//                 return Promise.reject('BAD REQUEST');
//             }
// 	    });
        
// }


// function removeEmp(empID){
//     var url = new URL("http://localhost:8080/employee/remove");
//     url.searchParams.set('empID', String(empID));
//     fetch(url,{
// 	        method:'POST',
// 	        headers:{
// 	            "Content-Type":"application/json"
// 	        }
// 	    })
// 		.then(response=>{
// 	        ////console.log(response);
// 	        if(response.status===202){
//                 console.log("Deleted Successfully");
// 	            return response.json();
//             }
// 	        else if(response.status===204){
//                 console.log("Employee does not exists");
// 	            return Promise.reject('Employee does not exists');
// 	        }
//             else if(response.status === 400 ){
//                 console.log("BAD REQUEST");
//                 return Promise.reject('BAD REQUEST');
//             }
// 	    });
// }
// function getAllEmps(){

//     let fetchPromise = fetch(`http://localhost:8080/employee/getAll`);
//     let p1 = fetchPromise.then((data)=>{
//         console.log(data);
//         if(data.status===200)
//         {
//             console.log('Response Received')
//             return data.json();
//         }else{
//             console.log(`Error in Fetching`)
//             return Promise.reject('Failed to Fetch Favorite Movies Records')
//         }
//     });
//     p1.then((response)=>{
// 		//console.log("favs:"+populateHtml(favs,"favouritesList"));
// 		empTableData = response;
//         populateHtmlAllEmp(response);
// 		// return(response);
//     })
//     p1.catch((error)=>{
//         ////console.log(error);
// 		// return error;
//     })
// 	return p1;

// }
// function getEmpByID(empID){
//     var url = new URL("http://localhost:8080/employee/getByID");
//     url.searchParams.set('empID', String(empID));
//     let fetchPromise = fetch(url);
//     let p1 = fetchPromise.then((data)=>{
//         console.log(data);
//         if(data.status===200)
//         {
//             console.log('Response Received')
//             return data.json();
//         }else{
//             console.log(`Error in Fetching`)
//             return Promise.reject('Failed to Fetch Favorite Movies Records')
//         }
//     });
//     p1.then((response)=>{
// 		empByID = response;
//         populateHtmlEmpByID(response);
// 		// return(response);
//     })
//     p1.catch((error)=>{
//         ////console.log(error);
// 		// return error;
//     })
// 	return p1;
// }

// function populateHtmlAllEmp(empList = null){
//     let check = true;
// 	if(!empList)
// 		check=false;
// 	if(check){
// 		let idToFill = document.getElementById('AllEmployeeTable');
//     	let bodyHtml='';
//     	empList.forEach(emp=>{
// 			////console.log(JSON.stringify(record));
// 			////console.log(typeof(record));
//     	    let tr = `<tr>
//                 <td>${emp.empID}</td>
//                 <td>${emp.empID}</td>
//                 <td>${emp.empName}</td>
//                 <td>${emp.empContact}</td>
//                 <td>${emp.empEmail}</td>
//         	</tr>`
//         	bodyHtml += tr;
//     	});
//     idToFill.innerHTML = bodyHtml;
// 	}
// }

// function populateHtmlEmpByID(emp){
//     document.getElementById('EmployeeByIDTable').innerHTML = `<tr>
//                 <td>${emp.empID}</td>
//                 <td>${emp.empID}</td>
//                 <td>${emp.empName}</td>
//                 <td>${emp.empContact}</td>
//                 <td>${emp.empEmail}</td>
//         	</tr>` ;
// }

// module.exports = {
//     addEmp,
//     removeEmp,
//     getAllEmps,
//     getEmpByID,
//     populateHtmlAllEmp,
//     populateHtmlEmpByID
// };
