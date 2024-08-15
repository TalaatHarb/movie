const JsonTable = ({ data }: any) => {
  // Filter out the null or undefined properties
  const nonNullEntries = Object.entries(data).filter(([_, value]) => value !== null && value !== undefined);

  // Check if there are non-null properties
  if (nonNullEntries.length === 0) {
    return <p>No data to display</p>;
  }

  return (
    <table className="table table-bordered table-striped">
      <thead>
        <tr>
          <th scope="col">Property</th>
          <th scope="col">Value</th>
        </tr>
      </thead>
      <tbody>
        {nonNullEntries.map(([key, value], index) => (
          <tr key={index}>
            <th scope="row">{key}</th>
            <td>{typeof value === 'object' ? JSON.stringify(value, null, 2) : value.toString()}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default JsonTable;
