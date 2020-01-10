node {
   echo 'Hello World'
    def url = new URL("https://github.com/smateti/hello/blob/master/README.md")
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
