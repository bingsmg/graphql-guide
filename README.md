# graphql-example

访问地址：
1. dgs：localhost:8081/graphiql
2. spring: localhost:8082/graphiql

## 查询示例

### Query

```graphql
{
  employeePart {
    AGE,
  }
}

query bookDetails {
  bookById(id: "book-1") {
    id
    name
    pageCount
    author {
      id
      firstName
      lastName
    }
  }
}
```

### Mutation
```graphql
mutation Post {
  createPost(
    postDTO: {title: "postTitle", text: "post1", category: "1level", authorId: "10001"}
  ) {
    id
    post_title:title
    category
  }
}


mutation productMutation {
    createProduct(productInput:{
        name:"pro1985948594",
        description: "Foo",
        cost: 0.2,
        tax: 3.4
    }) {
        name,
        description,
        cost,
        tax
    }
}
```
