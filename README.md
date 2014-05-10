## Qubole Data Service Java SDK
A Java library that provides the tools you need to authenticate with, and use the Qubole Data Service API.

## Installation
Currently, you will need to download and build from source:

* Clone the project: git clone git@github.com:qubole/qds-sdk-java.git
* cd to the directory
* mvn install

Then, in your Java application, using Maven, add a dependency:

```
<dependency>
    <groupId>com.qubole.qds-sdk-java</groupId>
    <artifactId>qds-sdk-java</artifactId>
    <version>THE-VERSION</version>
</dependency>
```

## Usage

In your application initialization code, allocate a QdsClient object:

```
QdsConfiguration configuration = new DefaultQdsConfiguration(YOUR_API_KEY);
QdsClient client = QdsClientFactory.newClient(configuration);
```

Then, make api calls as needed. E.g.

```
Future<CommandResponse> hiveCommandResponseFuture = client
    .command()
    .hive()
    .query("show tables;")
    .invoke();
CommandResponse hiveCommandResponse = hiveCommandResponseFuture.get();
...
```

Alternatively, you can use Jersey's callback mechanism. E.g.

```
InvocationCallback<CommandResponse> callback = new InvocationCallback<CommandResponse>()
{
    @Override
    public void completed(CommandResponse clusterItems)
    {
        // ...
    }

    @Override
    public void failed(Throwable throwable)
    {
        // ...
    }
};
client.command()
    .hive()
    .query("show tables;")
    .withCallback(callback)
    .invoke();
...
```

## APIs

Using the QdsClient, you can access any of the Qubole APIs:

| API | Example | Documentation |
| --- | ------- | ------------- |
| Reports API | client.report().allCommandsReport() ... | http://www.qubole.com/docs/documentation/reports-api/ |
| Scheduler API | client.scheduler().list().invoke(); | http://www.qubole.com/docs/documentation/scheduler-api/ |
| DbTaps API | client.dbTaps().list().invoke(); | http://www.qubole.com/docs/documentation/dbtaps-api-qds-api-reference/ |

## Javadoc

http://qubole.github.io/qds-sdk-java/apidocs/
