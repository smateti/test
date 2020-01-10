package org.foo

def checkOutFrom(repo) {
  echo "$repo"
   def url = new URL("https://github.com/smateti/hello/blob/master/README.md")
    HttpURLConnection connection = url.openConnection()

    connection.setRequestMethod("GET")
    connection.setDoInput(true)
    echo "2 $repo "
    try {
        connection.connect()
        new InputStreamReader(connection.getInputStream(), "UTF-8")
        echo " 3  $repo "
    } catch (FileNotFoundException e1) {
        echo "File not yet available: ${url.toString()}"
        return false
    } finally {
        connection.disconnect()
    }
}

return this
