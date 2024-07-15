# Image Descriptor Project

Welcome to the Image Descriptor Project. This project is designed to extract color and texture descriptors from images. It supports extracting color histograms and Local Binary Pattern (LBP) descriptors.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [License](#license)
- [Credits](#credits)

## Introduction

The Image Descriptor Project is a Java application that processes images to extract color and texture descriptors. The extracted descriptors can be used for various image processing tasks such as image retrieval, classification, and analysis.

## Features

- Extract color histogram descriptors with 256 bins for each RGB channel.
- Extract Local Binary Pattern (LBP) descriptors for texture analysis.
- Automatically detect and process images from a user-selected directory.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse

### Installation

1. Clone the repository:

```sh
git clone https://github.com/yourusername/image-descriptor-project.git
```

2. Open the project in your preferred IDE.

3. Ensure you have the necessary libraries imported (e.g., `javax.imageio`).

## Usage

1. Run the `ImageDescriptor` class.

2. When prompted, select the directory containing the images you want to process.

3. The application will process each image in the selected directory and output the color and texture descriptors to the console.

### Example Output


=================================
Welcome to the Image Descriptor Project
Created by Oussama Missaoui
=================================

Color descriptor for image example.jpg:
120 45 30 ... 255 128 0

Texture descriptor for image example.jpg:
5 10 0 ... 3 2 1

LBP descriptor for image example.jpg:
1 2 3 ... 4 5 6
...

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Credits

This project was created by Oussama Missaoui.


Make sure to replace `yourusername` with your actual GitHub username in the clone URL. Additionally, if you have a specific license file (e.g., MIT), include it in your project directory.
