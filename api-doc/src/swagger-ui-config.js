import SwagerUI, { plugins, presets } from 'swagger-ui';
import 'swagger-ui/dist/swagger-ui.css';

window.onload = function windowload() {
  const ui = SwagerUI({
    dom_id: '#swagger-ui',
    url: 'ticketmachine-bundle.yaml',
    presets: [
      presets.apis,
    ],
    filter: true,
    plugins: [
      plugins.Topbar,
    ],
  });
  window.ui = ui;
};
