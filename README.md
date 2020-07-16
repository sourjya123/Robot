# Robot
1. http://localhost:1234/robot/position ---> this will find the current position of a bot and also save as csv. This is POST Api.<br>
step1: open postman<br>
step2: select body and also select raw as json<br>
step3: paste the below request<br>
{

   "Position":{

      "Direction":"S",

      "X":10,

      "Y":10

   },

   "Move":[
{

         "O":"1",

         "L":90,

         "F":10

      },

      {

         "O":"2",

         "R":180,

         "B":20

      }
   ]

}

output: 
1. response status 201 created
2. response body 
{
    "direction": "W",
    "y": 10,
    "x": 40
}
2. http://localhost:1234/robot/position/from-file ---> this will read the current position of bot from csv. This is GET Api.
once you hit this url
response body
{
    "direction": "W",
    "y": 10,
    "x": 40
}
