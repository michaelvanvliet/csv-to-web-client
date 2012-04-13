#!/usr/bin/env groovy

/**
 * Please note! This script will only work when you have the
 * SimpleCompoundDatabaseGroovyClient.jar in your CLASSPATH
 * See: http://groovy.codehaus.org/Running
 */

import org.scdb.client.*

//def client = new SCDBConnect('http://yourApiUrl/api/')
def client = new SCDBConnect() // leave empty for default: http://localhost:8080/api/

println "# List labels"
def labels = client.labels()
println labels['count'] + ' labels found'
println labels['results']
println ""

println "# List all compounds"
def list = client.list()
println list['count'] + ' compounds found'
println list['results']
println ""

println "# List compound 1"
def compound = client.compound(1)
println compound['count'] + ' compounds found'
println compound['results']
println ""

// Also a more dynamic search is possible
def search
println "# Search compound where Cid = 3"
search = client.search('Cid','3', false)
println search['count'] + ' result(s) found'
println search['results']
println ""

println "# Search compound where InChI = InChI=1S/C3... , using regex"
search = client.search('InChI','InChI=1S/C3', true)
println search['count'] + ' result(s) found'
println search['results']
println ""

println "# Search compound where Elements = C4H5O6 , not using regex but an exact match"
search = client.search('Elements','C4H5O6', false)
println search['count'] + ' result(s) found'
println search['results']
println ""