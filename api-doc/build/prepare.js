const yaml = require('js-yaml');
const yamlinc = require('yaml-include');
const fs = require('fs');
const p = require('path');

yamlinc.setBaseFile(p.join(__dirname, '../src/api', 'api-spec.yaml'));
const src = fs.readFileSync(yamlinc.basefile, 'utf8');
const ymlobj = yaml.load(src, { schema: yamlinc.YAML_INCLUDE_SCHEMA, filename: yamlinc.basefile });
const dir = 'dist';


if (!fs.existsSync(dir)) {
  fs.mkdirSync(dir);
}

fs.writeFile(p.join(__dirname, '../', dir, '/ticketmachine-bundle.yaml'), yaml.dump(ymlobj), (err) => {
  if (err) throw err;

  console.log('bundled yml!!!!!');
});
