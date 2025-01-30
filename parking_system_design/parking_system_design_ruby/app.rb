require 'sinatra'

get '/test_setup' do
  content_type :json
  { status: "success" }.to_json
end

# define endpoint below as needed for submitting test.

