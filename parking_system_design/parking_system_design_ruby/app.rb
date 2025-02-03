require 'sinatra'

# https://github.com/sinatra/sinatra?tab=readme-ov-file#available-settings
# for preventing "attack prevented by Rack::Protection::HostAuthorization" error
# add your ngrok host to permitted_hosts below
set :host_authorization, :permitted_hosts => [".localhost", "9975530fb821.ngrok.app"]

# Code below is for testing the setup of the server, do not modify or else the first test
# might fail.
get '/test_setup' do
  content_type :json
  { status: "success" }.to_json
end

# curl --location --request POST 'localhost:4567/example_post_endpoint/12?foo=bar'
# below is an example of how to define a POST endpoint with path and query params
post '/example_post_endpoint/:id' do
  # query params can be read like this
  foo = @params['foo']
  # path params can be read like this
  id = @params['id']
  # request body params can be read like this
  req_body = JSON.parse(request.body.read) rescue nil

  content_type :json
  { status: "success", "id": id, "foo": foo, "req_body": req_body }.to_json
end

# Additional detail on how to use sinatara can be found here: https://github.com/sinatra/sinatra

# define routes below as needed for submitting test.
