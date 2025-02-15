# Dynamic Customer Finder

## Overview
This project implements a dynamic "Find Customer" view screen to enhance customer management. The primary email address serves as the unique identifier for each customer.

## Features
- **Customer Search**: Find customers using filters such as:
  - Email Address
  - First Name
  - Last Name
  - Contact Number
  - Postal Address
- **Sorting & Pagination**:
  - Sort by `combinedName` (First Name + Last Name).
  - Efficient pagination with metadata.
- **Customer Management**:
  - Create a new customer with `emailAddress`, `firstName`, and `lastName`.
  - Update a customer's `postalAddress` and `phoneNumber` using `emailAddress` as an identifier.

## Implementation Details

### FindCustomerView Entity
- Defined in `PartyViewEntities.xml`.
- Joins customer-related data for structured searching.
- Validated and tested for expected outputs.

### findCustomer Service
- Defined in `PartyServices.xml`.
- Accepts multiple filters (email, name, contact, address).
- Outputs customer list and pagination metadata.
- Fully tested and validated.

### FindCustomer.groovy Script
- Implements business logic for customer search.
- Optimized conditions and filters for efficiency.
- Integrates `FindCustomerView` entity.
- Handles sorting and pagination correctly.

### createCustomer and updateCustomer Services
- Implemented in `PartyServices.xml`:
  - `createCustomer`: Ensures unique email before adding a new record.
  - `updateCustomer`: Updates postal address and phone number for existing customers.
- Both services fully tested for accuracy.

## Conclusion
The assignment is successfully completed, and all components function as expected, meeting the objectives of the project.

