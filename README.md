[JAVA__BADGE]: https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white
[SPRING__BADGE]: https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white
[HIBERNATE__BADGE]: https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white
[POSTGRES__BADGE]: https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white
[MAVEN__BADGE]: https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white
[DOCKER__BADGE]: https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white

<h1 align="center" style="font-weight: bold;" id="table-of-contents">Technology certifications 💻✅</h1>

![java][JAVA__BADGE]
![springboot][SPRING__BADGE]
![hibernate][HIBERNATE__BADGE]
![postgres][POSTGRES__BADGE]
![maven][MAVEN__BADGE]
![docker][DOCKER__BADGE]

<p align="center">
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a>
</p>

<p align="center">
  <b>
   This API was developed to allows students to obtain technology certifications.
  </b>
</p>

<h2 id="started">🚀 Getting started</h2>

This is a step-by-step to help you to run this project in your machine.

<h3>Prerequisites</h3>

Before you start, you will need to have the following tools installed on your machine:

- [Java 17](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://docs.docker.com/get-docker/)

<h3>Cloning</h3>

To clone this repository, you will need to run the following command:

```bash
git clone https://github.com/bantheus/certification-api.git
```

<h3>Starting</h3>

To start the project, you will need to run the following commands:

```bash
cd certification-api
docker-compose up -d
mvn spring-boot:run
```

<h2 id="routes">📍 API Endpoints</h2>

This is a list of all routes that this API provides.
​
| route | description  
|----------------------|-----------------------------------------------------
| <kbd>GET /questions/technology/${TECHNOLOGY}</kbd> | retrieve all questions from a specific technology [request details](#get-questions-technology)
| <kbd>POST /students/verifyIfHasCertification</kbd> | verify if a student has a certification [request details](#post-students-verifyIfHasCertification)
| <kbd>POST /students/certification/answer</kbd> | answer a question from a certification [request details](#post-students-certification-answer)
| <kbd>GET /ranking/top10</kbd> | retrieve the top 10 students with higher grades [request details](#get-ranking-top10)

<h3 id="get-questions-technology">GET /questions/technology/JAVA</h3>

**RESPONSE**

```json
[
  {
    "id": "8a53c416-c77f-410a-82e4-b79c1d633320",
    "technology": "JAVA",
    "description": "Como criar uma classe em Java?",
    "alternatives": [
      {
        "id": "8a53c416-c77f-410a-82e4-b79c1d633323",
        "description": "public class MyClass {}"
      },
      {
        "id": "8a53c416-c77f-410a-82e4-b79c1d633324",
        "description": "public MyClass {}"
      },
      {
        "id": "8a53c416-c77f-410a-82e4-b79c1d633325",
        "description": "class MyClass {}"
      }
    ]
  }
]
```

<h3 id="post-students-verifyIfHasCertification">POST /students/verifyIfHasCertification</h3>

**REQUEST**

```json
{
  "email": "matheus@teste.com",
  "technology": "Java"
}
```

**RESPONSE**

```json
{
  Not certified!
}
```

<h3 id="post-students-certification-answer">POST /students/certification/answer</h3>

**REQUEST**

```json
{
  "email": "matheus@teste.com",
  "technology": "JAVA",
  "questionsAnswers": [
    {
      "questionId": "8a53c416-c77f-410a-82e4-b79c1d633320",
      "alternativeId": "8a53c416-c77f-410a-82e4-b79c1d633323"
    }
  ]
}
```

**RESPONSE**

```json
{
  "id": "564c687a-d9c0-4050-aad4-8cf7e5451cc3",
  "technology": "JAVA",
  "grade": 1,
  "studentId": "41623f9f-a8e6-488a-8bee-458bd7005ec4",
  "answersCertificationEntities": [
    {
      "id": "6788c852-60b7-437e-b01c-765c4d783e87",
      "certificationId": "564c687a-d9c0-4050-aad4-8cf7e5451cc3",
      "questionId": "8a53c416-c77f-410a-82e4-b79c1d633320",
      "answerId": "8a53c416-c77f-410a-82e4-b79c1d633323",
      "createdAt": "2024-05-13T11:41:45.52657",
      "correct": true
    }
  ]
}
```

<h3 id="get-ranking-top10">GET /ranking/top10</h3>

**RESPONSE**

```json
[
  {
    "id": "7f706182-c18c-44e1-8948-0b74069eec5d",
    "technology": "JAVA",
    "grade": 1,
    "studentId": "fe0f8e88-5457-491e-a8d2-ffb494ccddfc",
    "studentEntity": {
      "id": "fe0f8e88-5457-491e-a8d2-ffb494ccddfc",
      "email": "matheus@teste.com",
      "createdAt": "2024-05-10T16:53:48.305288"
    },
    "answersCertificationEntities": [],
    "createdAt": "2024-05-10T17:24:41.25088"
  }
]
```

<h2 id="colab">🤝 Collaborators</h2>

Here are the people who contributed to this project:

<table>
  <tr>
    <td align="center">
      <a href="https://github.com/bantheus">
        <img src="https://avatars.githubusercontent.com/u/70174902?v=4" width="100px;" alt="Matheus Schmidt"/><br>
        <sub>
          <b>Matheus Schmidt</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

<h2 id="license">📝 License</h2>

This project is under the MIT license.

[⬆ Back to top](#table-of-contents)
