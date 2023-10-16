# flowable
Flowable Open Source Setup

1. Flowable Engine with inmemory H2 db.
2. Simple process of Maker-Checker (Requester-Approver) will automatically be deployed to process engine once app starts.
3. Engine is running on port 8081.

**Rest API's to interact with Process are as below:**
1. Create/Initiate Process
   URL : http://localhost:8081/flowable/rest/process/v1/createFlowableProcess
   Method : POST
   Payload : {
       "processKey": "approvalFlow",
       "requestId": "99999",
       "item": "Bottles",
       "count": "33",
       "requestedBy": "Chanchal",
       "description": "Ordering 5 Bottles"
   }
   NOTE :- **processKey** is a mandatory variable to initiate process and other variables are optional. and any number of primitive variable case be created.

2. Get UnAssigned Tasks
   URL : http://localhost:8081/flowable/rest/task/v1/getUnAssignedTasks
   Method : GET
3. Claim Task
   URL : http://localhost:8081/flowable/rest/task/v1/claimTask?taskId=0cbfa0bf-6b43-11ee-9f8a-a0e70b8bcf0a&userId=chanchal
   Method : POST
4. Complete Task
   URL : http://localhost:8081/flowable/rest/task/v1/completeTask
    Method : POST
    Payload : {
   "taskId": "07d307e3-6b45-11ee-becc-a0e70b8bcf0a",
   "taskVariables": {
   "status": "Submitted"
   }
   }
5. Get Tasks by User
   URL : http://localhost:8081/flowable/rest/task/v1/getTasksByUser?assignee=chanchal
   Method : GET
6. Get All Tasks
   URL : http://localhost:8081/flowable/rest/task/v1/getAllTasks
   Method : GET
