# Robot

Download Postman from below url
https://www.postman.com/downloads/

Install the postman on your machine.
Then add a new tab and put the below url and follow below steps.

1. http://localhost:1234/robot/position ---> this will find the current position of a bot and also save as csv. This is POST Api.<br>
step1: open postman<br>
step2: select body and also select raw. From the dropdown list select json<br>. Select POST operation from the left side.
step3: paste the below request as body.<br>
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

output: <br>
a. response status 201 created<br>
b. response body <br>
{
    "direction": "W",
    "y": 10,
    "x": 40
}<br>
2. http://localhost:1234/robot/position/from-file ---> this will read the current position of bot from csv. This is GET Api.<br>
once you hit this url<br>
response body<br>
{
    "direction": "W",
    "y": 10,
    "x": 40
}
