const path = require('path');
const CopyWebpackPlugin = require('copy-webpack-plugin');
const WebpackShellPlugin = require('webpack-shell-plugin');

module.exports = {
  entry: path.resolve(__dirname, '..', 'src/swagger-ui-config.js'),
  output: {
    filename: 'bundle.js',
    path: path.resolve(__dirname, '..', 'dist/'),
  },
  devtool: 'inline-source-map',
  devServer: {
    contentBase: path.resolve(__dirname, '..', 'dist/'),
  },
  node: {
    fs: 'empty',
  },
  module: {
    rules: [
      {
        test: /\.css$/,
        use: [
          'style-loader',
          'css-loader',
        ],
      },
    ],
  },
  plugins: [
    new CopyWebpackPlugin([
      { from: 'src/web' },
      { from: 'src/api' },
    ]),
    new WebpackShellPlugin({
      onBuildStart: ['node build/prepare.js'],
      dev: false,
    }),
  ],
};
