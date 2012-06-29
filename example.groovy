#!/usr/bin/env groovy

/**
 * Please note! This script will only work when you have the
 * csv-to-web-client.jar in your CLASSPATH
 * See: http://groovy.codehaus.org/Running
 */

import org.csv2web.client.*

//def client = new Csv2WebConnect('http://yourApiUrl/api/')
def client = new Csv2WebConnect() // leave empty for default: http://localhost:8080/api/

println "# List labels"
def labels = client.labels()
println labels['count'] + ' labels found'
println labels['results']
println ""

println "# List all records"
def list = client.list()
println list['count'] + ' records found'
println list['results']
println ""

println "# List record 1"
def record = client.record(1)
println record['count'] + ' records found'
println record['results']
println ""

// Also a more dynamic search is possible
def search
println "# Search record where Rid = 3"
search = client.search('Rid','3', false)
println search['count'] + ' result(s) found'
println search['results']
println ""

println "# Search record where InChI = InChI=1S/C3... , using regex"
search = client.search('InChI','InChI=1S/C3', true)
println search['count'] + ' result(s) found'
println search['results']
println ""

println "# Search record where Elements = C4H5O6 , not using regex but an exact match"
search = client.search('Elements','C4H5O6', false)
println search['count'] + ' result(s) found'
println search['results']
println ""

println "# Search record where Rid >= 2 and Rid <= 4 (2,3,4)"
search = client.searchBetween('Rid','2', '4')
println search['count'] + ' result(s) found'
println search['results']
println ""