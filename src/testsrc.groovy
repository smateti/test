node {
   echo 'Hello World'
    def url = new URL("https://raw.githubusercontent.com/fabric8io/fabric8-pipeline-library/blob/master/pom.xml")
    HttpURLConnection connection = url.openConnection()

    connection.setRequestMethod("GET")
    connection.setDoInput(true)

    try {
        connection.connect()
        new InputStreamReader(connection.getInputStream(), "UTF-8")
        return true
    } catch (FileNotFoundException e1) {
        echo "File not yet available: ${url.toString()}"
        return false
    } finally {
        connection.disconnect()
    }
}
