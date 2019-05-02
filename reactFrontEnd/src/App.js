import React, { Component } from 'react'
import './App.css'

import axios from 'axios'

class App extends Component {
  constructor(){
    super()
    this.state={
      catgory:[],
      inventory: [],
      tree:[],
      isLoading: true,
      listLoad:true,
      treeload:true,
      errors: null
    }
    this.handleClick = this.handleClick.bind(this)
  }

  getCatgory(){
    axios
      .get("http://localhost:8080/all")
      .then(response =>
       response.data.map(catgory => ({
         id: `${catgory.id} `,
         title: `${catgory.title}`,
         pid: `${catgory.pid}`,
       }))
     )
     .then(catgory => {
        this.setState({
          catgory,
          isLoading: false
        });
      })
      .catch(error => this.setState({ error, isLoading: false }));

  }
  handleClick (id) {
    axios.get('http://localhost:8080/list', {
      params: {
        id: id
      }
    })
    .then(response =>
     response.data.map(inventory => ({
       id: `${inventory.id} `,
       name: `${inventory.name}`,
       catgoryId: `${inventory.catgoryId}`,
     }))
   )
   .then(inventory => {
      this.setState({
        inventory,
        listLoad: false
      });
    })
    .catch(error => this.setState({ error, listLoad: false }));
  }
  handleSubClick(id){
    axios.get('http://localhost:8080/find', {
      params: {
        id: id
      }
    })
    .then(response =>
     response.data.map(tree => ({
       id: `${tree.id} `,
       title: `${tree.title}`,
       pid: `${tree.pid}`,
     }))
   )
   .then(tree => {
      this.setState({
        tree,
        treeload: false
      });
    })
    .catch(error => this.setState({ error, treeload: false }));
  }

  handleDeleteClick(inventory){
    axios.get('http://localhost:8080/delete', {
      params: {
        id: inventory.id
      }
    })
    var array=[...this.state.inventory];
    var index=array.indexOf(inventory)

    if (index !== -1) {
      array.splice(index, 1);
      this.setState({inventory: array});
    }
  }
  componentDidMount() {
    this.getCatgory();
  }


  render () {
    const { isLoading,listLoad,treeload,tree, catgory,inventory } = this.state;
    return (
      <React.Fragment>
        {/*catgory selector */}
        <div class="w3-container">
        <div class="left">
          <h2>Catgory Selector</h2>
          {!isLoading ? (
            catgory.map(catgory => {
              const { id, title, pid } = catgory;
              return (
                <ul class="w3-ul">
                  <li o>
                    {id} {title}
                    <p>
                    <button class="w3-button w3-pale-green" onClick={()=>this.handleClick(id)}>item</button>
                    </p>
                    <p>
                    <button class="w3-button w3-pale-green" onClick={()=>this.handleSubClick(id)}>SubCatgories</button>
                    </p>

                </li>

                </ul>
              );
            })
          ) : (
            <p>Loading...</p>
          )}
        </div>
        {/*Inventories selector */}
        <div class="left">
          <h2>Inventories</h2>
          {!listLoad ? (
            inventory.map(inventory => {
              const { id, name, catgoryId } = inventory;
              return (
                <ul class="w3-ul">
                  <li>{id} {name}
                    <p>
                    <button class="w3-button w3-red" onClick={()=>this.handleDeleteClick(inventory)}>delete</button>
                    </p>
                  </li>

                </ul>
              );
            })
          ) : (
            <p>Loading...</p>
          )}
        </div>
        {/*subcatgory selector */}
        <div class="left">
          <h2>subcatgory</h2>
          {!treeload ? (
            tree.map(tree => {
              const { id, title, pid } = tree;
              return (
                <ul class="w3-ul">
                  <li>{id} {title}</li>
                </ul>
              );
            })
          ) : (
            <p>Loading...</p>
          )}
        </div>
        </div>
      </React.Fragment>
    )
  }
}
export default App
