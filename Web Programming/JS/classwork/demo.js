class Student{
    
    constructor(rollNo, stdName){
        console.log("Para constructor")
        this.stdName=stdName
        this.rollNo=rollNo
    }

    display(){
        console.log("Roll No.: "+this.rollNo+" Name: "+this.stdName+"")
    }

}

s=new Student(101, "Bramha")
s.display()