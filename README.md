# Online doctor application

This console application make diagnosis for a patient by their symptoms. 
A patient can also book an appointment with doctor that is a specialist in particular sphere.
The application implements **State design pattern**.

## Interaction with user

* **Enter your data in format** ```'surname' 'name' 'age'```
  (e.g. ```Ivanov Ivan 18```)
* **Main menu:**
  1) **Get diagnosis**
     * User chooses appropriate symptoms
     * At the end the user must choose the option: ```I have no more symptoms```
     * After that the user receives their diagnosis and the list of doctors that are the specialists in that sphere
  2) **Admin panel (considered in separate section)**
  3) **Ask a question to doctor**
     * The user chooses the doctor they want to speak with, then ask their question.
  4) **Book an appointment with a doctor**
     * The user can choose the doctor to whom he wants to make an appointment
  5) **Quit**
  
## Admin panel (requires password)

Interaction with administrator of the application. <br>
The admin can:
1) **Show all doctors**
2) **Show doctor for concrete diagnosis** <br> 
The admin needs to input the diagnosis.
3) **Set doctor's salary** <br> 
The admin chooses doctor firstly (by their name), and specifies their new salary (by typing it)
4) **Show doctors' salaries**
5) **Show doctor's timetable** <br>
The admin need to input their full name
6) **Show all doctors' timetables** <br>
7) **Change doctors timetable** <br>
The admin input the doctor's full name, then inputs new timetable
8) **Add doctor to diagnosis** <br>
The admin can add diagnosis to doctors. For example, if doctor Ivanov Ivan have learned now to cure allergy, the admin can add information about it.
The admin should input the diagnosis name, then doctor's full name.
9) **Show diagnosis info** <br>
The admin inputs the diagnosis name
10) **Leave admin panel**

## The developers team:
**Kamil Almetov** (k.almetov@innopolis.university) <br>
**Kirill Korolev** (k.korolev@innopolis.university) <br>
**Nagim Isyanbayev** (n.isyanbayev@innopolis.university) <br>
**Viktor Kovalev** (vi.kovalev@innopolis.university)